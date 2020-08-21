// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;
  /* free format */
@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _PyManagedBufferObject extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _PyManagedBufferObject() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _PyManagedBufferObject(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _PyManagedBufferObject(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _PyManagedBufferObject position(long position) {
        return (_PyManagedBufferObject)super.position(position);
    }
    @Override public _PyManagedBufferObject getPointer(long i) {
        return new _PyManagedBufferObject(this).position(position + i);
    }

    public native @ByRef PyObject ob_base(); public native _PyManagedBufferObject ob_base(PyObject setter);
    public native int flags(); public native _PyManagedBufferObject flags(int setter);          /* state flags */
    public native @Cast("Py_ssize_t") long exports(); public native _PyManagedBufferObject exports(long setter); /* number of direct memoryview exports */
    public native @ByRef Py_buffer master(); public native _PyManagedBufferObject master(Py_buffer setter); /* snapshot buffer obtained from the original exporter */
}
