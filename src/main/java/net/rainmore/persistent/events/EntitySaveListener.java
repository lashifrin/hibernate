package net.rainmore.persistent.events;

import org.hibernate.event.spi.SaveOrUpdateEvent;

public class EntitySaveListener extends EntitySaveOrUpdateListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        super.onSaveOrUpdate(event);
    }
}
