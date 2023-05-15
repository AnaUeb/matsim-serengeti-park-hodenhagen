package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.ActivityEndEvent;
import org.matsim.api.core.v01.events.ActivityStartEvent;
import org.matsim.api.core.v01.events.handler.ActivityEndEventHandler;
import org.matsim.api.core.v01.events.handler.ActivityStartEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;

public class VerySimplePersonEventHandler implements ActivityEndEventHandler, ActivityStartEventHandler {

    private final Map<Id<Person>, Double> actEndTimes = new HashMap<>();
    @Override
    public void handleEvent(ActivityEndEvent event) {

        if (event.getActType().endsWith("interaction")) return; //otherwise durations near to zero
        var endTime = event.getTime();
        var personId = event.getPersonId();
        actEndTimes.put(personId, endTime);

    }

    @Override
    public void handleEvent(ActivityStartEvent event) {

        if (event.getActType().endsWith("interaction")) return; //otherwise durations near to zero
        var startTime = event.getTime();
        var personId = event.getPersonId();
        var endTime = actEndTimes.get(personId);
        var duration = startTime - endTime; //end of last activity and start of new activity

        System.out.println("Person "+personId+" travelled for: "+duration);

    }
}
