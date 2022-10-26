/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.api.context;

import io.opentelemetry.instrumentation.api.instrumenter.ContextCustomizer;
import java.util.LinkedList;
import java.util.List;

public final class GlobalContextsRegistry {

  private static final List<ContextCustomizer<Object>> GLOBAL_CONTEXTS = new LinkedList<>();

  private GlobalContextsRegistry() {}

  public static void register(ContextCustomizer<Object> contextCustomizer) {
    GLOBAL_CONTEXTS.add(contextCustomizer);
  }

  public static List<ContextCustomizer<Object>> getGlobalContexts() {
    return GLOBAL_CONTEXTS;
  }
}
