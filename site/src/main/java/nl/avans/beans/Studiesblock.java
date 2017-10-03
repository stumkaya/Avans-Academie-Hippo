package nl.avans.beans;

import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@HippoEssentialsGenerated(internalName = "aaadegrees:studiesblock")
@Node(jcrType = "aaadegrees:studiesblock")
public class Studiesblock extends HippoDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:title")
    public String getTitle() {
        return getProperty("aaadegrees:title");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:link")
    public String getLink() {
        return getProperty("aaadegrees:link");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:image")
    public HippoGalleryImageSet getImage() {
        return getLinkedBean("aaadegrees:image", HippoGalleryImageSet.class);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:subtitle")
    public String getSubtitle() {
        return getProperty("aaadegrees:subtitle");
    }
}
