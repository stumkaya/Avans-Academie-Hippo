package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;

@HippoEssentialsGenerated(internalName = "aaadegrees:practicalinfoblock")
@Node(jcrType = "aaadegrees:practicalinfoblock")
public class Practicalinfoblock extends HippoDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:description")
    public String getDescription() {
        return getProperty("aaadegrees:description");
    }

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

    @HippoEssentialsGenerated(internalName = "aaadegrees:linktext")
    public String getLinktext() {
        return getProperty("aaadegrees:linktext");
    }
}
