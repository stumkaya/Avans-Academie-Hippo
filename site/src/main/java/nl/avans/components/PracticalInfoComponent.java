package nl.avans.components;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParametersInfo(type = PracticalInfoComponentInfo.class)
public class PracticalInfoComponent extends BaseHstComponent {
    public static final Logger log = LoggerFactory.getLogger(PracticalInfoComponent.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        setEditMode(request);
        final HstRequestContext ctx = request.getRequestContext();
        PracticalInfoComponentInfo paramsInfo = getComponentParametersInfo(request);
        String documentLocation = paramsInfo.getPracticalInfoLocation();

        final HippoBean document = ctx.getSiteContentBaseBean().getBean(documentLocation);

        if (document == null) {
            return;
        }
        request.setAttribute("document", document);
    }

    protected void setEditMode(HstRequest request) {
        request.setAttribute("editMode", Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }
}

interface PracticalInfoComponentInfo {
    String PARAM_SNIPPETLOCATION = "richTextLocation";
    @Parameter(name = PARAM_SNIPPETLOCATION, displayName = "Practical Info Document Location")
    @JcrPath(isRelative = true, pickerInitialPath = "practical-information/practical-info", pickerSelectableNodeTypes = {"aaadegrees:practicalinfo"}, pickerConfiguration = "cms-pickers/documents-only")
    String getPracticalInfoLocation();
}


