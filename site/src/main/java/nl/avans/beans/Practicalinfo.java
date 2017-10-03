package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import java.util.List;
import nl.avans.beans.Practicalinfoblock;

@HippoEssentialsGenerated(internalName = "aaadegrees:practicalinfo")
@Node(jcrType = "aaadegrees:practicalinfo")
public class Practicalinfo extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:stickymenuitem")
    public String getStickymenuitem() {
        return getProperty("aaadegrees:stickymenuitem");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:introduction")
    public String getIntroduction() {
        return getProperty("aaadegrees:introduction");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:blocks")
    public List<Practicalinfoblock> getBlocks() {
        return getChildBeansByName("aaadegrees:blocks",
                Practicalinfoblock.class);
    }
}
