package br.univel.model.account;

/**
 * Created by felipefrizzo on 9/15/16.
 */
public interface AccountObserver {
    void haveChanges(final AccountInterface account);
}
