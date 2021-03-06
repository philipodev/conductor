package com.netflix.conductor.jedis;

import com.google.common.collect.Lists;

import com.netflix.conductor.core.config.Configuration;
import com.netflix.dyno.connectionpool.Host;
import com.netflix.dyno.connectionpool.HostSupplier;

import javax.inject.Inject;
import javax.inject.Provider;

public class LocalHostSupplierProvider implements Provider<HostSupplier> {
    private final Configuration configuration;

    @Inject
    public LocalHostSupplierProvider(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public HostSupplier get() {
        Host dynoHost = new Host("localhost", 0, configuration.getAvailabilityZone(), Host.Status.Up);
        return ()-> Lists.newArrayList(dynoHost);
    }
}
