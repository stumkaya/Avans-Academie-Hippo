package nl.avans.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import java.util.List;
import nl.avans.beans.Studiesblock;

@HippoEssentialsGenerated(internalName = "aaadegrees:studiesoverview")
@Node(jcrType = "aaadegrees:studiesoverview")
public class Studiesoverview extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:description")
    public HippoHtml getDescription() {
        return getHippoHtml("aaadegrees:description");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:studies")
    public List<Studiesblock> getStudies() {
        return getChildBeansByName("aaadegrees:studies", Studiesblock.class);
    }
}
