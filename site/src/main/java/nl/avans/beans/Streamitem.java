package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;

@HippoEssentialsGenerated(internalName = "aaadegrees:streamitem")
@Node(jcrType = "aaadegrees:streamitem")
public class Streamitem extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:url")
    public String getUrl() {
        return getProperty("aaadegrees:url");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:title")
    public String getTitle() {
        return getProperty("aaadegrees:title");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:chapeau")
    public String getChapeau() {
        return getProperty("aaadegrees:chapeau");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:image")
    public HippoGalleryImageSet getImage() {
        return getLinkedBean("aaadegrees:image", HippoGalleryImageSet.class);
    }
}
