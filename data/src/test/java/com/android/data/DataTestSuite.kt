package com.android.data

import com.android.data.mapper.GameMapperTest
import com.android.data.repository.GameRepositoryImplTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GameMapperTest::class,
    GameRepositoryImplTest::class
)
class DataTestSuite