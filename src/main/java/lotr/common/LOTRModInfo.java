/*
 * Decompiled with CFR 0.148.
 */
package lotr.common;

public class LOTRModInfo {
    public static final String modID = "lotr";
    public static final String modName = "The Lord of the Rings Mod";
    public static final String version = "Update v36.12 for Minecraft 1.7.10";
    public static final String[] description = new String[]{"Based on The Lord of the Rings and other works by J.R.R. Tolkien:", "The Lord of the Rings Mod adds the world of Middle-earth and its peoples to Minecraft, with many new blocks, items, weapons, mobs, and more. Explore the regions of Middle-earth, discovering unique structures and resources, mining new ores, meeting both friends and foes. Trade, earn achievements, complete quests, even hire and command your own armies.", "Choose your side - will you fight with the Free Peoples, or serve the Shadow?", "A note on Canon:", "We consider it a priority to remain consistent with the creation of J.R.R. Tolkien. For some features of the mod, notably Harad and Rh\u00c3\u00bbn, we have invented our own content based on sensible extrapolations from Tolkien's writings, in order to present a more complete world and playing experience. However, those concerned about canon should be careful not to treat the content of this mod as an authoritative adaptation of Tolkien's works. Our adaptation is intended to be faithful to the spirit of Middle-earth, but it is only one possible interpretation of what might have lain within those empty spaces on the map."};

    public static final String concatenateDescription(int startIndex) {
        String s = "";
        for (int i = startIndex = java.lang.Math.min(startIndex, description.length - 1); i < description.length; ++i) {
            s = s + description[i] + "\n\n";
        }
        return s;
    }
}

