package org.matsim.analysis;

import org.matsim.core.events.EventsUtils;

public class RunAnalysis {
    public static void main(String[] args) {

        var handler = new VerySimplePersonEventHandler();
        var manager = EventsUtils.createEventsManager();
        manager.addHandler(handler);                        //connect handler wirh manager
        EventsUtils.readEvents(manager,"C:\\Users\\anaue\\Documents\\TUBerlin\\MatSim\\matsim-serengeti-park-hodenhagen\\scenarios\\serengeti-park-v1.0\\output\\output-serengeti-park-v1.0-run1\\serengeti-park-v1.0-run1.output_events.xml.gz");

    }
}
