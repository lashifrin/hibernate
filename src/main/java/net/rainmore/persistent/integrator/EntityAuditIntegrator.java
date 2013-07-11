package net.rainmore.persistent.integrator;

import net.rainmore.persistent.events.EntitySaveOrUpdateListener;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class EntityAuditIntegrator implements Integrator {

    public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        final EventListenerRegistry eventListenerRegistry = sessionFactoryServiceRegistry.getService( EventListenerRegistry.class );
        eventListenerRegistry.prependListeners(EventType.SAVE_UPDATE, new EntitySaveOrUpdateListener());
    }

    public void integrate(MetadataImplementor metadataImplementor, SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void disintegrate(SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
