package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import java.util.List;
import nl.avans.beans.Year;
import nl.avans.util.SearchUtils;

@HippoEssentialsGenerated(internalName = "aaadegrees:program")
@Node(jcrType = "aaadegrees:program")
public class Program extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:chapeau")
    public String getChapeau() {
        return getProperty("aaadegrees:chapeau");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:title")
    public String getTitle() {
        return getProperty("aaadegrees:title");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:year")
    public List<Year> getYear() {
        return getChildBeansByName("aaadegrees:year", Year.class);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:stickymenuitem")
    public String getStickymenuitem() {
        return getProperty("aaadegrees:stickymenuitem");
    }

    public String getSearchResultText(String searchText) {
        for(Year year : getYear()) {
            String content = year.getContent().getContent();
            if (content.toLowerCase().contains(searchText.toLowerCase())) {
                return SearchUtils.highlight(content, searchText);
            }
        }
        //If the search term is not found in the content, it probably means it is in the title,
        // so just return some content to show
        for(Year year : getYear()) {
            String content = year.getContent().getContent();
            return SearchUtils.getContent(content);
        }

        return null;
    }
}
