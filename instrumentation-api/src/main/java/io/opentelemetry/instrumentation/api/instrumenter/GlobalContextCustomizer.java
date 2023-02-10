/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/**
 * Customizer of the {@link Context}. The {@link #onStart(Context, Object, Attributes)} method will
 * be called during the {@linkplain Instrumenter#start(Context, Object) <code>Instrumenter</code>
 * start}, allowing customization of the {@link Context} just before the {@link Instrumenter}
 * returns it.
 */
@FunctionalInterface
public interface GlobalContextCustomizer {

  /** Allows to customize the operation {@link Context}. */
  <REQUEST> Context onStart(Context parentContext, REQUEST request, Attributes startAttributes);
}
