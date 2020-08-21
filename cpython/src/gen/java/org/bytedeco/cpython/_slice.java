// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _slice extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _slice() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _slice(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _slice(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _slice position(long position) {
        return (_slice)super.position(position);
    }
    @Override public _slice getPointer(long i) {
        return new _slice(this).position(position + i);
    }

    public native @Cast("_slice_kind") int kind(); public native _slice kind(int setter);
            @Name("v.Slice.lower") public native _expr v_Slice_lower(); public native _slice v_Slice_lower(_expr setter);
            @Name("v.Slice.upper") public native _expr v_Slice_upper(); public native _slice v_Slice_upper(_expr setter);
            @Name("v.Slice.step") public native _expr v_Slice_step(); public native _slice v_Slice_step(_expr setter);

            @Name("v.ExtSlice.dims") public native asdl_seq v_ExtSlice_dims(); public native _slice v_ExtSlice_dims(asdl_seq setter);

            @Name("v.Index.value") public native _expr v_Index_value(); public native _slice v_Index_value(_expr setter);
}
