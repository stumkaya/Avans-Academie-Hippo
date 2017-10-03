package nl.avans.components;

import java.util.LinkedList;
import java.util.List;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.builder.HstQueryBuilder;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.FieldGroup;
import org.hippoecm.hst.core.parameters.FieldGroupList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParametersInfo(type = StreamComponentInfo.class)
public class StreamComponent extends BaseHstComponent {
    public static final Logger log = LoggerFactory.getLogger(StreamComponent.class);
    public static final int STREAM_LENGTH = 8;
    public static final String AAADEGREES_NEWSDOCUMENT = "aaadegrees:newsdocument";
    public static final String HIPPOSTDPUBWF_PUBLICATION_DATE = "hippostdpubwf:publicationDate";
    public static final String DOCUMENT_LIST = "documentList";
    public static final String EDIT_MODE = "editMode";

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        try {
            super.doBeforeRender(request, response);
            setEditMode(request);
            final HstRequestContext ctx = request.getRequestContext();
            StreamComponentInfo paramsInfo = getComponentParametersInfo(request);
            List<HippoBean> documentList = getDocumentsBeanList(ctx, paramsInfo);


            if (documentList == null || documentList.isEmpty() || documentList.size() < STREAM_LENGTH) {
                HstQueryBuilder builder = HstQueryBuilder.create(request.getRequestContext().getSiteContentBaseBean());
                HstQuery hstQuery = builder.ofPrimaryTypes(AAADEGREES_NEWSDOCUMENT).build();
                hstQuery.addOrderByDescending(HIPPOSTDPUBWF_PUBLICATION_DATE);
                hstQuery.setLimit(STREAM_LENGTH);
                final HstQueryResult execute = hstQuery.execute();
                HippoBeanIterator hippoBeanIterator = execute.getHippoBeans();
                while (hippoBeanIterator.hasNext() && documentList.size() < STREAM_LENGTH) {
                    HippoBean bean = hippoBeanIterator.nextHippoBean();
                    if (!documentList.contains(bean)) {
                        documentList.add(bean);
                    }
                }

            }
            request.setAttribute(DOCUMENT_LIST, documentList);
        } catch (QueryException e) {

        }
    }

    protected void setEditMode(HstRequest request) {
        request.setAttribute(EDIT_MODE, Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }

    protected List<HippoBean> getDocumentsBeanList(HstRequestContext ctx, StreamComponentInfo paramsInfo) {

        List<HippoBean> documentList = new LinkedList<>();

        if (!paramsInfo.getPinned1().isEmpty() && !documentList.contains(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned1()))) {
            documentList.add(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned1()));
        }
        if (!paramsInfo.getPinned2().isEmpty() && !documentList.contains(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned2()))) {
            documentList.add(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned2()));
        }
        if (!paramsInfo.getPinned3().isEmpty() && !documentList.contains(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned3()))) {
            documentList.add(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned3()));
        }
        if (!paramsInfo.getPinned4().isEmpty() && !documentList.contains(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned4()))) {
            documentList.add(ctx.getSiteContentBaseBean().getBean(paramsInfo.getPinned4()));
        }

        return documentList;
    }
}


@FieldGroupList({
        @FieldGroup(
                titleKey = "group.pinned",
                value = {"pinned1", "pinned2", "pinned3", "pinned4"}
        )
})
interface StreamComponentInfo {

    @Parameter(name = "pinned1")
    @JcrPath(isRelative = true, pickerInitialPath = "", pickerSelectableNodeTypes = {"aaadegrees:newsdocument", "aaadegrees:eventsdocument", "aaadegrees:streamitem"}, pickerConfiguration = "cms-pickers/documents-only")
    String getPinned1();

    @Parameter(name = "pinned2")
    @JcrPath(isRelative = true, pickerInitialPath = "", pickerSelectableNodeTypes = {"aaadegrees:newsdocument", "aaadegrees:eventsdocument", "aaadegrees:streamitem"}, pickerConfiguration = "cms-pickers/documents-only")
    String getPinned2();

    @Parameter(name = "pinned3")
    @JcrPath(isRelative = true, pickerInitialPath = "", pickerSelectableNodeTypes = {"aaadegrees:newsdocument", "aaadegrees:eventsdocument", "aaadegrees:streamitem"}, pickerConfiguration = "cms-pickers/documents-only")
    String getPinned3();

    @Parameter(name = "pinned4")
    @JcrPath(isRelative = true, pickerInitialPath = "", pickerSelectableNodeTypes = {"aaadegrees:newsdocument", "aaadegrees:eventsdocument", "aaadegrees:streamitem"}, pickerConfiguration = "cms-pickers/documents-only")
    String getPinned4();

}