package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@HippoEssentialsGenerated(internalName = "aaadegrees:homepage")
@Node(jcrType = "aaadegrees:homepage")
public class Homepage extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:youtubecode")
    public String getYoutubecode() {
        return getProperty("aaadegrees:youtubecode");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:banner")
    public HippoBean getBanner() {
        return getLinkedBean("aaadegrees:banner", HippoBean.class);
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:event")
    public HippoBean getEvent() {
        return getLinkedBean("aaadegrees:event", HippoBean.class);
    }
}
