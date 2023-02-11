/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.api.context;

import io.opentelemetry.instrumentation.api.instrumenter.MutableSpanEndProcessor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class MutableSpanEndProcessorRegistry {

  private static final List<MutableSpanEndProcessor> MUTABLE_SPAN_END_PROCESSORS =
      new LinkedList<>();

  private MutableSpanEndProcessorRegistry() {}

  public static void register(MutableSpanEndProcessor mutableSpanEndProcessor) {
    MUTABLE_SPAN_END_PROCESSORS.add(mutableSpanEndProcessor);
  }

  public static List<MutableSpanEndProcessor> getMutableSpanEndProcessors() {
    return Collections.unmodifiableList(MUTABLE_SPAN_END_PROCESSORS);
  }
}
