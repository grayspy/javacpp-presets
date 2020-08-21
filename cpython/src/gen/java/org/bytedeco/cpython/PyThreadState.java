// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;



@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class PyThreadState extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyThreadState() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyThreadState(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyThreadState(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyThreadState position(long position) {
        return (PyThreadState)super.position(position);
    }
    @Override public PyThreadState getPointer(long i) {
        return new PyThreadState(this).position(position + i);
    }

    /* See Python/ceval.c for comments explaining most fields */

    public native _ts prev(); public native PyThreadState prev(_ts setter);
    public native _ts next(); public native PyThreadState next(_ts setter);
    public native PyInterpreterState interp(); public native PyThreadState interp(PyInterpreterState setter);

    /* Borrowed reference to the current frame (it can be NULL) */
    public native _frame frame(); public native PyThreadState frame(_frame setter);
    public native int recursion_depth(); public native PyThreadState recursion_depth(int setter);
    public native @Cast("char") byte overflowed(); public native PyThreadState overflowed(byte setter); /* The stack has overflowed. Allow 50 more calls
                        to handle the runtime error. */
    public native @Cast("char") byte recursion_critical(); public native PyThreadState recursion_critical(byte setter); /* The current calls must not cause
                                a stack overflow. */
    public native int stackcheck_counter(); public native PyThreadState stackcheck_counter(int setter);

    /* 'tracing' keeps track of the execution depth when tracing/profiling.
       This is to prevent the actual trace/profile code from being recorded in
       the trace/profile. */
    public native int tracing(); public native PyThreadState tracing(int setter);
    public native int use_tracing(); public native PyThreadState use_tracing(int setter);

    public native Py_tracefunc c_profilefunc(); public native PyThreadState c_profilefunc(Py_tracefunc setter);
    public native Py_tracefunc c_tracefunc(); public native PyThreadState c_tracefunc(Py_tracefunc setter);
    public native PyObject c_profileobj(); public native PyThreadState c_profileobj(PyObject setter);
    public native PyObject c_traceobj(); public native PyThreadState c_traceobj(PyObject setter);

    /* The exception currently being raised */
    public native PyObject curexc_type(); public native PyThreadState curexc_type(PyObject setter);
    public native PyObject curexc_value(); public native PyThreadState curexc_value(PyObject setter);
    public native PyObject curexc_traceback(); public native PyThreadState curexc_traceback(PyObject setter);

    /* The exception currently being handled, if no coroutines/generators
     * are present. Always last element on the stack referred to be exc_info.
     */
    public native @ByRef _PyErr_StackItem exc_state(); public native PyThreadState exc_state(_PyErr_StackItem setter);

    /* Pointer to the top of the stack of the exceptions currently
     * being handled */
    public native _PyErr_StackItem exc_info(); public native PyThreadState exc_info(_PyErr_StackItem setter);

    public native PyObject dict(); public native PyThreadState dict(PyObject setter);  /* Stores per-thread state */

    public native int gilstate_counter(); public native PyThreadState gilstate_counter(int setter);

    public native PyObject async_exc(); public native PyThreadState async_exc(PyObject setter); /* Asynchronous exception to raise */
    public native @Cast("unsigned long") long thread_id(); public native PyThreadState thread_id(long setter); /* Thread id where this tstate was created */

    public native int trash_delete_nesting(); public native PyThreadState trash_delete_nesting(int setter);
    public native PyObject trash_delete_later(); public native PyThreadState trash_delete_later(PyObject setter);

    /* Called when a thread state is deleted normally, but not when it
     * is destroyed after fork().
     * Pain:  to prevent rare but fatal shutdown errors (issue 18808),
     * Thread.join() must wait for the join'ed thread's tstate to be unlinked
     * from the tstate chain.  That happens at the end of a thread's life,
     * in pystate.c.
     * The obvious way doesn't quite work:  create a lock which the tstate
     * unlinking code releases, and have Thread.join() wait to acquire that
     * lock.  The problem is that we _are_ at the end of the thread's life:
     * if the thread holds the last reference to the lock, decref'ing the
     * lock will delete the lock, and that may trigger arbitrary Python code
     * if there's a weakref, with a callback, to the lock.  But by this time
     * _PyThreadState_Current is already NULL, so only the simplest of C code
     * can be allowed to run (in particular it must not be possible to
     * release the GIL).
     * So instead of holding the lock directly, the tstate holds a weakref to
     * the lock:  that's the value of on_delete_data below.  Decref'ing a
     * weakref is harmless.
     * on_delete points to _threadmodule.c's static release_sentinel() function.
     * After the tstate is unlinked, release_sentinel is called with the
     * weakref-to-lock (on_delete_data) argument, and release_sentinel releases
     * the indirectly held lock.
     */
    public static class On_delete_Pointer extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    On_delete_Pointer(Pointer p) { super(p); }
        protected On_delete_Pointer() { allocate(); }
        private native void allocate();
        public native void call(Pointer arg0);
    }
    public native On_delete_Pointer on_delete(); public native PyThreadState on_delete(On_delete_Pointer setter);
    public native Pointer on_delete_data(); public native PyThreadState on_delete_data(Pointer setter);

    public native int coroutine_origin_tracking_depth(); public native PyThreadState coroutine_origin_tracking_depth(int setter);

    public native PyObject coroutine_wrapper(); public native PyThreadState coroutine_wrapper(PyObject setter);
    public native int in_coroutine_wrapper(); public native PyThreadState in_coroutine_wrapper(int setter);

    public native PyObject async_gen_firstiter(); public native PyThreadState async_gen_firstiter(PyObject setter);
    public native PyObject async_gen_finalizer(); public native PyThreadState async_gen_finalizer(PyObject setter);

    public native PyObject context(); public native PyThreadState context(PyObject setter);
    public native @Cast("uint64_t") long context_ver(); public native PyThreadState context_ver(long setter);

    /* Unique thread state id. */
    public native @Cast("uint64_t") long id(); public native PyThreadState id(long setter);

    /* XXX signal handlers should also be here */

}
