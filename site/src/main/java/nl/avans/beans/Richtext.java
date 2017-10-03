package nl.avans.beans;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import nl.avans.util.SearchUtils;

@HippoEssentialsGenerated(internalName = "aaadegrees:richtext")
@Node(jcrType = "aaadegrees:richtext")
public class Richtext extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:chapeau")
    public String getChapeau() {
        return getProperty("aaadegrees:chapeau");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:title")
    public String getTitle() {
        return getProperty("aaadegrees:title");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:content")
    public HippoHtml getContent() {
        return getHippoHtml("aaadegrees:content");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:stickymenuitem")
    public String getStickymenuitem() {
        return getProperty("aaadegrees:stickymenuitem");
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
