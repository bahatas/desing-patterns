package com.builder.methodlevel;

import lombok.Builder;
import lombok.Value;

@Builder
@Value //  as it doesnt have setters only have getters under @Value that makes objects immutable.
final class ImmutableStudent {
    private int id;
    private String name;
}