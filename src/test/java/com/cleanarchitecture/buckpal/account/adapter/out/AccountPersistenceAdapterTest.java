package com.cleanarchitecture.buckpal.account.adapter.out;

import static com.cleanarchitecture.buckpal.common.AccountTestData.*;
import static com.cleanarchitecture.buckpal.common.ActivityTestData.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import com.cleanarchitecture.buckpal.account.adapter.out.persistence.AccountMapper;
import com.cleanarchitecture.buckpal.account.adapter.out.persistence.AccountPersistenceAdapter;
import com.cleanarchitecture.buckpal.account.adapter.out.persistence.ActivityJpaEntity;
import com.cleanarchitecture.buckpal.account.adapter.out.persistence.ActivityRepository;
import com.cleanarchitecture.buckpal.account.domain.Account;
import com.cleanarchitecture.buckpal.account.domain.Account.AccountId;
import com.cleanarchitecture.buckpal.account.domain.ActivityWindow;
import com.cleanarchitecture.buckpal.account.domain.Money;

@DataJpaTest
@Import({AccountPersistenceAdapter.class, AccountMapper.class})
class AccountPersistenceAdapterTest {

	@Autowired
	private AccountPersistenceAdapter adapterUnderTest;

	@Autowired
	private ActivityRepository activityRepository;

	@Test
	@Sql("classpath:AccountPersistenceAdapterTest.sql")
	void loadsAccount() {
		Account account = adapterUnderTest.loadAccount(new AccountId(1L), LocalDateTime.of(2018, 8, 10, 0, 0));

		assertThat(account.getActivityWindow().getActivities()).hasSize(2);
		assertThat(account.calculateBalance()).isEqualTo(Money.of(500));
	}

	@Test
	void updatesActivities() {
		Account account = defaultAccount()
			.withBaselineBalance(Money.of(555L))
			.withActivityWindow(new ActivityWindow(
				defaultActivity()
					.withId(null)
					.withMoney(Money.of(1L)).build()))
			.build();

		adapterUnderTest.updateActivities(account);

		assertThat(activityRepository.count()).isEqualTo(1);

		ActivityJpaEntity savedActivity = activityRepository.findAll().get(0);
		assertThat(savedActivity.getAmount()).isEqualTo(1L);
	}
}
