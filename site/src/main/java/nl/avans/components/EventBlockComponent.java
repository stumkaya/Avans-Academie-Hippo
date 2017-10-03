package nl.avans.components;

import java.util.Calendar;
import java.util.Date;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.DropDownList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.hippoecm.repository.util.DateTools;
import org.onehippo.cms7.essentials.components.info.EssentialsEventsComponentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.avans.beans.EventsDocument;

@ParametersInfo(type = EventBlockComponentInfo.class)
public class EventBlockComponent extends BaseHstComponent {

    public static final Logger log = LoggerFactory.getLogger(EventBlockComponent.class);
    public static final String KOM_LANGS = "Kom langs";

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        try {
            setEditMode(request);
            String cta;
            EventBlockComponentInfo paramInfo = (EventBlockComponentInfo)this.getComponentParametersInfo(request);
            if("".equals(paramInfo.getCta())){
                cta = KOM_LANGS;
            } else {
                cta = paramInfo.getCta();
            }
            request.setAttribute("cta", cta);
            final HstRequestContext ctx = request.getRequestContext();
            if(paramInfo.getEventDocument() == null || "".equals(paramInfo.getEventDocument())) {
                HippoBean contentBaseBean = ctx.getSiteContentBaseBean();
                HstQuery hstQuery = ctx.getQueryManager().createQuery(contentBaseBean, "aaadegrees:eventsdocument");
                hstQuery.setLimit(1);
                hstQuery.addOrderByAscending("aaadegrees:date");

                Filter dateFilter = hstQuery.createFilter();
                dateFilter.addGreaterOrEqualThan("aaadegrees:enddate", Calendar.getInstance(), DateTools.Resolution.DAY);
                hstQuery.setFilter(dateFilter);

                if(paramInfo.isMainEvent()) {
                    Filter mainEventFilter = hstQuery.createFilter();
                    mainEventFilter.addEqualTo("aaadegrees:category", "main");
                    hstQuery.setFilter(mainEventFilter);
                }

                HstQueryResult result = hstQuery.execute();
                EventsDocument document = (EventsDocument) result.getHippoBeans().nextHippoBean();
                request.setAttribute("document", document);
            } else {
                final HippoBean document = ctx.getSiteContentBaseBean().getBean(paramInfo.getEventDocument());

                Calendar date = document.getProperty("aaadegrees:enddate");
                if(date.after(Calendar.getInstance())) {
                    request.setAttribute("document", document);
                } else {
                    request.setAttribute("document", null);
                }
            }
        } catch (QueryException e) {
            log.debug("Error on EventBlockComponent", e);
        }
    }

    protected void setEditMode(HstRequest request) {
        request.setAttribute("editMode", Boolean.valueOf(RequestContextProvider.get().isCmsRequest()));
    }
}

interface EventBlockComponentInfo {
    String PARAM_CTA = "cta";
    String PARAM_EVENT = "event";
    String PARAM_MAIN_EVENT = "main";

    @Parameter(name = PARAM_CTA, displayName = "Call To Action")
    String getCta();

    @Parameter(name = PARAM_EVENT, displayName = "Event Document")
    @JcrPath(isRelative = true, pickerInitialPath = "events", pickerSelectableNodeTypes = {"aaadegrees:eventsdocument"}, pickerConfiguration = "cms-pickers/documents-only")
    String getEventDocument();

    @Parameter(name = PARAM_MAIN_EVENT, displayName = "Show Main Events Only")
    Boolean isMainEvent();

}
