package net.rainmore.persistent.events;

import net.rainmore.common.persistent.AbstractEntity;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

public class EntitySaveOrUpdateListener extends DefaultSaveOrUpdateEventListener {
    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        if (event.getObject() instanceof AbstractEntity) {
            AbstractEntity record = (AbstractEntity) event.getObject();

            if (record.getSysCreatedDate() == null)
                record.prePersist();
            else
                record.preUpdate();

//            // set the Updated date/time
//            record.setSysUpdatedDate(new DateTime());
//
//            // set the Created date/time
//            if (record.getSysCreatedDate() == null) {
//                record.setSysCreatedDate(new DateTime());
//            }
        }
    }
}
