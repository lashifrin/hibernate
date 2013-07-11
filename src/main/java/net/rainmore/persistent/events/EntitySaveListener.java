package net.rainmore.persistent.events;

import net.rainmore.common.DataEntity;
import org.hibernate.event.internal.DefaultSaveEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.joda.time.DateTime;

public class EntitySaveListener extends EntitySaveOrUpdateListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        super.onSaveOrUpdate(event);
    }
}
