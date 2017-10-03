package nl.avans.components;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.site.HstServices;
import org.onehippo.forge.selection.hst.contentbean.ValueList;
import org.onehippo.forge.selection.hst.manager.ValueListManager;
import org.onehippo.forge.selection.hst.util.SelectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooterComponent extends BaseHstComponent {

    private static Logger log = LoggerFactory.getLogger(FooterComponent.class);

    @Override
    public void doBeforeRender(final HstRequest request, final HstResponse response) {
        super.doBeforeRender(request, response);
        setEditMode(request);
        ValueListManager valueListManager = HstServices.getComponentManager().getComponent(ValueListManager.class.getName());
        HippoBean siteContentBaseBean = request.getRequestContext().getSiteContentBaseBean();
        ValueList socialmediaValueList = valueListManager.getValueList(siteContentBaseBean, "socialmedia");
        if (socialmediaValueList != null) {
            request.setAttribute("socialmedia", SelectionUtil.valueListAsMap(socialmediaValueList));
        }

        request.setAttribute("location", request.getRequestContext().getSiteContentBaseBean().getBean("common/footer"));
    }
    protected void setEditMode(HstRequest request) {
        request.setAttribute("editMode", Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }
}
