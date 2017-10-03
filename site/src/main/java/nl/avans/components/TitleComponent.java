package nl.avans.components;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.Parameter;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.onehippo.cms7.essentials.components.EssentialsListComponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParametersInfo(type = TitleComponentInfo.class)
public class TitleComponent extends BaseHstComponent {

    private static Logger log = LoggerFactory.getLogger(TitleComponent.class);


    @Override
    public void doBeforeRender(final HstRequest request, final HstResponse response) {
        super.doBeforeRender(request, response);
        setEditMode(request);
        final TitleComponentInfo paramInfo = getComponentParametersInfo(request);
        request.setAttribute("title", paramInfo.getTitle());
    }

    protected void setEditMode(HstRequest request) {
        request.setAttribute("editMode", Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }

}

interface TitleComponentInfo {

    @Parameter(name = "title", displayName = "Title",required = false)
    String getTitle();

}
