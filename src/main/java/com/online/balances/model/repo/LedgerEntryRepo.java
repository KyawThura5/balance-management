package com.online.balances.model.repo;

import com.online.balances.model.BaseRepository;
import com.online.balances.model.entity.LedgerEntry;
import com.online.balances.model.entity.embeddables.LedgerEntryPK;

public interface LedgerEntryRepo extends BaseRepository<LedgerEntry, LedgerEntryPK> {

}
