package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

@HippoEssentialsGenerated(internalName = "aaadegrees:year")
@Node(jcrType = "aaadegrees:year")
public class Year extends HippoDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:title")
    public String getTitle() {
        return getProperty("aaadegrees:title");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:content")
    public HippoHtml getContent() {
        return getHippoHtml("aaadegrees:content");
    }
}
