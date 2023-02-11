/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.api.context;

import io.opentelemetry.instrumentation.api.instrumenter.GlobalContextCustomizer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

public final class GlobalContextsRegistry {

  private static final List<GlobalContextCustomizer> GLOBAL_CONTEXTS = new LinkedList<>();

  static {
    init();
  }

  private GlobalContextsRegistry() {}

  private static void init() {
    ServiceLoader<GlobalContextCustomizer> loader =
        ServiceLoader.load(GlobalContextCustomizer.class);
    loader.forEach(
        contextCustomizer -> {
          GLOBAL_CONTEXTS.add(contextCustomizer);
        });
  }

  public static void register(GlobalContextCustomizer contextCustomizer) {
    GLOBAL_CONTEXTS.add(contextCustomizer);
  }

  public static List<GlobalContextCustomizer> getGlobalContexts() {
    return Collections.unmodifiableList(GLOBAL_CONTEXTS);
  }
}
