// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::compute") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FilterOptions extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public FilterOptions() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FilterOptions(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FilterOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public FilterOptions position(long position) {
        return (FilterOptions)super.position(position);
    }

  /** Configure the action taken when a slot of the selection mask is null */
  public enum NullSelectionBehavior {
    /** the corresponding filtered value will be removed in the output */
    DROP(0),
    /** the corresponding filtered value will be null in the output */
    EMIT_NULL(1);

      public final int value;
      private NullSelectionBehavior(int v) { this.value = v; }
      private NullSelectionBehavior(NullSelectionBehavior e) { this.value = e.value; }
      public NullSelectionBehavior intern() { for (NullSelectionBehavior e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  public native NullSelectionBehavior null_selection_behavior(); public native FilterOptions null_selection_behavior(NullSelectionBehavior setter);
}