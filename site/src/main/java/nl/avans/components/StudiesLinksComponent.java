package nl.avans.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.Parameter;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ParametersInfo(type = StudiesLinksComponentInfo.class)
public class StudiesLinksComponent extends BaseHstComponent {

    public static final Logger log = LoggerFactory.getLogger(StudiesLinksComponent.class);
    public static final String STUDIES = "studies/";
    public static final String STUDIES_PATH = "content/documents/aaadegrees/studies";
    public static final String HIPPOSTD_FOLDER = "hippostd:folder";
    public static final String EDIT_MODE = "editMode";
    public static final String TITLE = "title";
    public static final String CHAPEAU = "chapeau";
    public static final String STUDIES_LIST = "studiesList";

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        final HstRequestContext ctx = request.getRequestContext();
        setEditMode(request);
        final StudiesLinksComponentInfo paramInfo = getComponentParametersInfo(request);
        request.setAttribute(TITLE, paramInfo.getTitle());
        request.setAttribute(CHAPEAU, paramInfo.getChapeau());


        List<HippoBean> studiesList = new ArrayList<>();

        try {
            Node rootNode = ctx.getSession().getRootNode();
            Node studiesFolder = rootNode.getNode(STUDIES_PATH);
            NodeIterator nodeIterator = studiesFolder.getNodes();
            while (nodeIterator.hasNext()) {
                Node study = nodeIterator.nextNode();
                HippoBean baseBean = ctx.getSiteContentBaseBean();

                if (HIPPOSTD_FOLDER.equals(study.getPrimaryNodeType().getName())) {
                    HippoBean folderBean = baseBean.getBean(STUDIES +study.getName(), HippoFolderBean.class);
                    studiesList.add(folderBean);
                }
            }
        } catch (RepositoryException e) {
            log.debug("Error creating Studies Links", e);
        }

        request.setAttribute(STUDIES_LIST, studiesList);
    }

    protected void setEditMode(HstRequest request) {
        request.setAttribute(EDIT_MODE, Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }
}

interface StudiesLinksComponentInfo {

    @Parameter(name = "chapeau", displayName = "Chapeau",required = false)
    String getChapeau();

    @Parameter(name = "title", displayName = "Title",required = false)
    String getTitle();
}
