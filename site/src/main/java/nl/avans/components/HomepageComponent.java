package nl.avans.components;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomepageComponent extends BaseHstComponent {
    public static final Logger log = LoggerFactory.getLogger(HomepageComponent.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        setEditMode(request);
        final HippoBean document = request.getRequestContext().getContentBean();

        if (document == null) {
            return;
        }
        request.setAttribute("document", document);
    }

    protected void setEditMode(HstRequest request) {
        request.setAttribute("editMode", Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }
}
