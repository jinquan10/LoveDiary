package org.jz.lovediary;

public final class PersistenceRule {
    public interface Api<T> {
        boolean canBePersisted(T o);
    }

    private static abstract class AbsPersistenceRule<T> {
        protected T o;

        public void init(T o) {
            this.o = o;
        }
    }

    public static class PerWord extends AbsPersistenceRule<String> implements Api<String> {
        @Override
        public boolean canBePersisted(String o) {
            return false;
        }
    }

    public static class SameState extends AbsPersistenceRule<Object> implements Api<Object> {
        @Override
        public boolean canBePersisted(Object o) {
            return false;
        }
    }

    public static class Time extends AbsPersistenceRule<Long> implements Api<Long> {
        @Override
        public boolean canBePersisted(Long o) {
            return false;
        }
    }
}
