package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import nl.avans.util.SearchUtils;

@HippoEssentialsGenerated(internalName = "aaadegrees:bannerdocument")
@Node(jcrType = "aaadegrees:bannerdocument")
public class Banner extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:title")
    public String getTitle() {
        return getProperty("aaadegrees:title");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:content")
    public HippoHtml getContent() {
        return getHippoHtml("aaadegrees:content");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:image")
    public HippoGalleryImageSet getImage() {
        return getLinkedBean("aaadegrees:image", HippoGalleryImageSet.class);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:link")
    public HippoBean getLink() {
        return getLinkedBean("aaadegrees:link", HippoBean.class);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:cta")
    public String getCta() {
        return getProperty("aaadegrees:cta");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:linkurl")
    public String getLinkurl() {
        return getProperty("aaadegrees:linkurl");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:linktext")
    public String getLinktext() {
        return getProperty("aaadegrees:linktext");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:subtitle")
    public String getSubtitle() {
        return getProperty("aaadegrees:subtitle");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:mobileimage")
    public HippoBean getMobileimage() {
        return getLinkedBean("aaadegrees:mobileimage", HippoBean.class);
    }

    public String getSearchResultText(String searchText) {
        String content = getContent().getContent();
        if (content.toLowerCase().contains(searchText.toLowerCase())) {
            return SearchUtils.highlight(content, searchText);
        }
        return SearchUtils.getContent(content);
    }

}
