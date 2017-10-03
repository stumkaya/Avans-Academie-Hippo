package nl.avans.beans;

import java.util.Calendar;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import nl.avans.util.SearchUtils;

@HippoEssentialsGenerated(internalName = "aaadegrees:eventsdocument")
@Node(jcrType = "aaadegrees:eventsdocument")
public class EventsDocument extends HippoDocument {
    /** 
     * The document type of the events document.
     */
    public final static String DOCUMENT_TYPE = "aaadegrees:eventsdocument";
    private final static String TITLE = "aaadegrees:title";
    private final static String DATE = "aaadegrees:date";
    private final static String INTRODUCTION = "aaadegrees:introduction";
    private final static String IMAGE = "aaadegrees:image";
    private final static String CONTENT = "aaadegrees:content";
    private final static String LOCATION = "aaadegrees:location";
    private final static String END_DATE = "aaadegrees:enddate";

    /** 
     * Get the date of the document, i.e. the start date of the event.
     * @return the (start) date
     */
    @HippoEssentialsGenerated(internalName = "aaadegrees:date")
    public Calendar getDate() {
        return getProperty(DATE);
    }

    /** 
     * Get the image of the document.
     * @return the image
     */
    @HippoEssentialsGenerated(internalName = "aaadegrees:image")
    public HippoGalleryImageSet getImage() {
        return getLinkedBean(IMAGE, HippoGalleryImageSet.class);
    }

    /** 
     * Get the main content of the document.
     * @return the content
     */
    @HippoEssentialsGenerated(internalName = "aaadegrees:content")
    public HippoHtml getContent() {
        return getHippoHtml(CONTENT);
    }

    /** 
     * Get the location of the document.
     * @return the location
     */
    @HippoEssentialsGenerated(internalName = "aaadegrees:location")
    public String getLocation() {
        return getProperty(LOCATION);
    }

    /** 
     * Get the end date of the document, i.e. the end date of the event.
     * @return the end date
     */
    @HippoEssentialsGenerated(internalName = "aaadegrees:enddate")
    public Calendar getEndDate() {
        return getProperty(END_DATE);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:chapeau")
    public String getChapeau() {
        return getProperty("aaadegrees:chapeau");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:title1")
    public String getTitle1() {
        return getProperty("aaadegrees:title1");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:title2")
    public String getTitle2() {
        return getProperty("aaadegrees:title2");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:cta")
    public String getCta() {
        return getProperty("aaadegrees:cta");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:ctaUrl")
    public String getCtaUrl() {
        return getProperty("aaadegrees:ctaUrl");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:time")
    public String getTime() {
        return getProperty("aaadegrees:time");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:imagemobile")
    public HippoGalleryImageSet getImagemobile() {
        return getLinkedBean("aaadegrees:imagemobile",
                HippoGalleryImageSet.class);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:category")
    public String getCategory() {
        return getProperty("aaadegrees:category");
    }

    public String getSearchResultText(String searchText) {
        String content = getContent().getContent();
        if (content.toLowerCase().contains(searchText.toLowerCase())) {
            return SearchUtils.highlight(content, searchText);
        }
        return SearchUtils.getContent(content);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:secondcontent")
    public HippoHtml getSecondcontent() {
        return getHippoHtml("aaadegrees:secondcontent");
    }
}
