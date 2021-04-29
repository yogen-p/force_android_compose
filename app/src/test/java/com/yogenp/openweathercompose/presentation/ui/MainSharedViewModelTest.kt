package com.yogenp.openweathercompose.presentation.ui

import com.yogenp.openweathercompose.repository.ForceRepository
import com.yogenp.openweathercompose.util.FORCE_INFO_DUMMY
import com.yogenp.openweathercompose.util.FORCE_LIST_DUMMY
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MainSharedViewModelTest : TestCase() {

    lateinit var repository: ForceRepository
    lateinit var viewModel: MainSharedViewModel
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    public override fun setUp() {
        super.setUp()
        Dispatchers.setMain(dispatcher)
        repository = mock(ForceRepository::class.java)
        viewModel = MainSharedViewModel(repository)
    }

    @Test
    fun `get force list`(): Unit = runBlockingTest {

        `when`(repository.getForceList()).thenReturn(FORCE_LIST_DUMMY)

        viewModel.newSearch()
        assertEquals(FORCE_LIST_DUMMY, viewModel.forces.value)
    }

    @Test
    fun `get force info`(): Unit = runBlockingTest {
        `when`(repository.getForceInfo("derbyshire")).thenReturn(FORCE_INFO_DUMMY)

        viewModel.selectForce("derbyshire")
        assertEquals(FORCE_INFO_DUMMY, viewModel.forceInfo.value)
    }

    @After
    public override fun tearDown() {
        super.tearDown()
        Dispatchers.resetMain()
    }

}