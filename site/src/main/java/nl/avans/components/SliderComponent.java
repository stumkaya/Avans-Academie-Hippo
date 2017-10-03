package nl.avans.components;

import java.util.ArrayList;
import java.util.List;

import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.FieldGroup;
import org.hippoecm.hst.core.parameters.FieldGroupList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.onehippo.cms7.essentials.components.EssentialsCarouselComponent;
import org.onehippo.cms7.essentials.components.paging.DefaultPagination;


@ParametersInfo(type = SliderComponentInfo.class)
public class SliderComponent extends EssentialsCarouselComponent {

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        setEditMode(request);
        this.setComponentId(request, response);
        SliderComponentInfo paramInfo = this.getComponentParametersInfo(request);
        request.setAttribute("cparam", paramInfo);
        List items = this.getCarouselItems(paramInfo);
        request.setAttribute("pageable", new DefaultPagination<>(items));
    }

    public List<HippoDocument> getCarouselItems(SliderComponentInfo componentInfo) {
        ArrayList beans = new ArrayList();
        this.addBeanForPath(componentInfo.getCarouselItem1(), beans);
        this.addBeanForPath(componentInfo.getCarouselItem2(), beans);
        this.addBeanForPath(componentInfo.getCarouselItem3(), beans);
        this.addBeanForPath(componentInfo.getCarouselItem4(), beans);
        this.addBeanForPath(componentInfo.getCarouselItem5(), beans);
        this.addBeanForPath(componentInfo.getCarouselItem6(), beans);
        return beans;
    }
}


@FieldGroupList({@FieldGroup(
        titleKey = "group.documents",
        value = {"document1", "document2", "document3", "document4", "document5", "document6"}
)})
interface SliderComponentInfo {

    String HIPPO_DOCUMENT = "hippo:document";
    String BANNERS_INITIAL_PATH = "banners";
    String CMS_PICKERS_DOCUMENTS_ONLY = "cms-pickers/documents-only";

    @Parameter(
            name = "document1",
            required = true
    )
    @JcrPath(
            isRelative = true,
            pickerInitialPath = "banners",
            pickerSelectableNodeTypes = {"hippo:document"},
            pickerConfiguration = "cms-pickers/documents-only"
    )
    String getCarouselItem1();

    @Parameter(
            name = "document2",
            required = false
    )
    @JcrPath(
            isRelative = true,
            pickerInitialPath = "banners",
            pickerSelectableNodeTypes = {"hippo:document"},
            pickerConfiguration = "cms-pickers/documents-only"
    )
    String getCarouselItem2();

    @Parameter(
            name = "document3",
            required = false
    )
    @JcrPath(
            isRelative = true,
            pickerInitialPath = "banners",
            pickerSelectableNodeTypes = {"hippo:document"},
            pickerConfiguration = "cms-pickers/documents-only"
    )
    String getCarouselItem3();

    @Parameter(
            name = "document4",
            required = false
    )
    @JcrPath(
            isRelative = true,
            pickerInitialPath = "banners",
            pickerSelectableNodeTypes = {"hippo:document"},
            pickerConfiguration = "cms-pickers/documents-only"
    )
    String getCarouselItem4();

    @Parameter(
            name = "document5",
            required = false
    )
    @JcrPath(
            isRelative = true,
            pickerInitialPath = "banners",
            pickerSelectableNodeTypes = {"hippo:document"},
            pickerConfiguration = "cms-pickers/documents-only"
    )
    String getCarouselItem5();

    @Parameter(
            name = "document6",
            required = false
    )
    @JcrPath(
            isRelative = true,
            pickerInitialPath = "banners",
            pickerSelectableNodeTypes = {"hippo:document"},
            pickerConfiguration = "cms-pickers/documents-only"
    )
    String getCarouselItem6();
}
