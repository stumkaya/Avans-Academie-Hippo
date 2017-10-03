package nl.avans.pagecopy;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.ValueFactory;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import org.hippoecm.hst.core.container.ComponentManager;
import org.hippoecm.hst.core.container.ComponentManagerAware;
import org.hippoecm.hst.pagecomposer.jaxrs.api.PageCopyContext;
import org.hippoecm.hst.pagecomposer.jaxrs.api.PageCopyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PageCopyEventListener implements ComponentManagerAware {

    private static Logger log = LoggerFactory.getLogger(PageCopyEventListener.class);

    private ComponentManager componentManager;

    @Override
    public void setComponentManager(ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    public void init() {
        componentManager.registerEventSubscriber(this);
    }

    public void destroy() {
        componentManager.unregisterEventSubscriber(this);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void onPageCopyEvent(PageCopyEvent event) {
        if (event.getException() != null) {
            return;
        }

        try {
            log.debug("Page copy listener kicking in!");

            PageCopyContext pgCpyCtx = event.getPageCopyContext();
            Session session = pgCpyCtx.getRequestContext().getSession();
            Node sourceNode = pgCpyCtx.getSourcePageNode();
            Node newNode = pgCpyCtx.getNewPageNode();
            Node workspaceNode = sourceNode.getParent();

            while (workspaceNode == null || !"hst:workspace".equals(workspaceNode.getName())) {
                workspaceNode = workspaceNode.getParent();
            }

            Node newMenuNode = workspaceNode.addNode("hst:sitemenus/quicklinks-" + newNode.getName(), "hst:sitemenu");
            Node prototypeNode = newMenuNode.addNode("hst:prototypeitem", "hst:sitemenuitem");

            ValueFactory valueFactory = session.getValueFactory();
            Value[] parameterNameValues = new Value[1];
            parameterNameValues[0] = valueFactory.createValue("Anchor");
            prototypeNode.setProperty("hst:parameternames", parameterNameValues);

            Value[] parameterValuesValues = new Value[1];
            parameterValuesValues[0] = valueFactory.createValue("");
            prototypeNode.setProperty("hst:parametervalues", parameterValuesValues);

            updateMenuName(newNode, valueFactory, event);


        } catch (RepositoryException e) {
            log.error("Error copying page", e);
            return;
        }


        // DO YOUR STUFF BUT MAKE SURE TO NEVER
        // SAVE THE JCR SESSION FOR THAT IS ACCESSIBLE VIA
        // THE PageCopyEvent#getPageCopyContext#getRequestContext
    }

    private void updateMenuName(Node node, ValueFactory valueFactory, PageCopyEvent event) {

        try {
            NodeIterator nodeIterator = node.getNodes();
            while (nodeIterator.hasNext()) {
                Node childNode = nodeIterator.nextNode();
                if ("hst:containeritemcomponent".equals(childNode.getPrimaryNodeType().getName()) &&
                        "quicklinks".equals(childNode.getName())) {
                    Value[] menuValues = new Value[1];
                    menuValues[0] = valueFactory.createValue("quicklinks-" + event.getPageCopyContext().getNewPageNode().getName());
                    childNode.setProperty("hst:parametervalues", menuValues);
                }
                updateMenuName(childNode, valueFactory, event);
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

}
