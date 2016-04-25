package org.jz.lovediary.api;

/**
 * Created by JZ on 4/23/2016.
 */
public final class AndroidMVPApi {
    public interface View<TPresenter extends Presenter> {

    }

    public interface Presenter<T extends AndroidMVPApi.View> {
        void onViewReady(T view);
    }

    public interface Provider {

    }
}
