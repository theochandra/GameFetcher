package com.financords.data

import com.financords.data.mapper.GameMapperTest
import com.financords.data.repository.GameRepositoryImplTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GameMapperTest::class,
    GameRepositoryImplTest::class
)
class DataTestSuite