package nl.avans.components;

import java.util.List;

import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.filter.BaseFilter;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.onehippo.cms7.essentials.components.EssentialsSearchComponent;
import org.onehippo.cms7.essentials.components.info.EssentialsPageable;
import org.onehippo.cms7.essentials.components.info.EssentialsSearchComponentInfo;
import org.onehippo.cms7.essentials.components.paging.Pageable;

@ParametersInfo(type = EssentialsSearchComponentInfo.class)
public class SearchComponent extends EssentialsSearchComponent {

    @Override
    protected void populateRequest(final HstRequest request, final EssentialsPageable paramInfo, Pageable<? extends HippoBean> pageable) {

        request.setAttribute(REQUEST_ATTR_QUERY, getSearchQuery(request));
        request.setAttribute(REQUEST_ATTR_PAGEABLE, pageable);
        request.setAttribute(REQUEST_ATTR_PARAM_INFO, paramInfo);

        if (pageable != null) {
            pageable.setShowPagination(isShowPagination(request, paramInfo));
        }
    }

    @Override
    protected void contributeAndFilters(final List<BaseFilter> filters, final HstRequest request, final HstQuery query) {
        Filter docTypesFilter = query.createFilter();
        docTypesFilter.addJCRExpression("@jcr:primaryType='aaadegrees:bannerdocument' or @jcr:primaryType='aaadegrees:eventsdocument' or @jcr:primaryType='aaadegrees:newsdocument' or @jcr:primaryType='aaadegrees:program' or @jcr:primaryType='aaadegrees:richtext'");
        filters.add(docTypesFilter);
    }


}
