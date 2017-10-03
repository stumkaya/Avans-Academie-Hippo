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

@ParametersInfo(type = ProgramComponentInfo.class)
public class ProgramComponent extends BaseHstComponent {

    private static Logger log = LoggerFactory.getLogger(ProgramComponent.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        setEditMode(request);
        final HstRequestContext ctx = request.getRequestContext();
        ProgramComponentInfo paramsInfo = getComponentParametersInfo(request);

        String documentLocation = paramsInfo.getProgramLocation();
        log.debug("document location specified in hst is " + documentLocation);

        final HippoBean document = ctx.getSiteContentBaseBean().getBean(documentLocation);
        log.debug("snippet document is " + document);

        if (document == null) {
            return;
        }
        request.setAttribute("document", document);
    }

    protected void setEditMode(HstRequest request) {
        request.setAttribute("editMode", Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }
}

interface ProgramComponentInfo {
    String PARAM_PROGRAMLOCATION = "programLocation";

    @Parameter(name = PARAM_PROGRAMLOCATION, required = true, displayName = "Program Document")
    @JcrPath(isRelative = true, pickerInitialPath = "", pickerSelectableNodeTypes = {"aaadegrees:program"}, pickerConfiguration = "cms-pickers/documents-only")
    String getProgramLocation();
}