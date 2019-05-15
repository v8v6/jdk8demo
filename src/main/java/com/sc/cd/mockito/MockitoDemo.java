package com.sc.cd.mockito;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;

import lombok.extern.slf4j.Slf4j;
/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-09 15:44
 */

@Slf4j
public class MockitoDemo {

    /*@Test
    public void createMockObject() {

        // 使用 mock 静态方法创建 Mock 对象.
        List mockedList = mock(List.class);
        Assert.assertTrue(mockedList instanceof List);

        // mock 方法不仅可以 Mock 接口类, 还可以 Mock 具体的类型.
        ArrayList mockedArrayList = mock(ArrayList.class);
        Assert.assertTrue(mockedArrayList instanceof List);
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
    }

    @Test
    public void verify_behaviour(){
        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        mock.add(1);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
    }

    @Test
    public void configMockObject() {
        List mockedList = mock(List.class);

        // 我们定制了当调用 mockedList.add("one") 时, 返回 true
        when(mockedList.add("one")).thenReturn(true);
        // 当调用 mockedList.size() 时, 返回 1
        when(mockedList.size()).thenReturn(1);

        Assert.assertTrue(mockedList.add("one"));
        // 因为我们没有定制 add("two"), 因此返回默认值, 即 false.
        Assert.assertFalse(mockedList.add("two"));
        Assert.assertEquals(mockedList.size(), 1);

        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = i.next() + " " + i.next();
        //assert
        Assert.assertEquals("Hello, Mockito!", result);
    }

    @Test(expected = NoSuchElementException.class)
    public void testForIOException() throws Exception {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello,").thenReturn("Mockito!"); // 1
        String result = i.next() + " " + i.next(); // 2
        Assert.assertEquals("Hello, Mockito!", result);

        doThrow(new NoSuchElementException()).when(i).next(); // 3
        i.next(); // 4
    }

    @Test
    public void testVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(mockedList.size(), 5);

        mockedList.isEmpty();
        verify(mockedList, atLeastOnce()).add("one");
        verify(mockedList, times(1)).add("two");
        verify(mockedList, times(3)).add("three times");
        verify(mockedList, never()).isEmpty();
    }


    @Test
    public void testVerify1(){
        //You can mock concrete classes, not only interfaces
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        // 输出“first”
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        // 抛出异常
        //System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        // 因为get(999) 没有打桩，因此输出null
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
        //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
        // 验证get(0)被调用的次数
        verify(mockedList,times(2)).get(0);
    }

    @Test
    public void testMatchers() {
        LinkedList mockedList = mock(LinkedList.class);
        //stubbing using built-in anyInt() argument matcher
        // 使用内置的anyInt()参数匹配器
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        // 使用自定义的参数匹配器( 在isValid()函数中返回你自己的匹配器实现 )
        *//*when(mockedList.contains(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String argument) {
                return false;
            }
        }))).thenReturn("11");*//*

        //following prints "element"
        // 输出element
        System.out.println(mockedList.get(999));

        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        // 你也可以验证参数匹配器
        verify(mockedList).get(anyInt());


        List mock = mock(List.class);

        *//*verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
        //above is correct - eq() is also an argument matcher
        // 上述代码是正确的,因为eq()也是一个参数匹配器

                verify(mock).someMethod(anyInt(), anyString(), "third argument");
        //above is incorrect - exception will be thrown because third argument
        // 上述代码是错误的,因为所有参数必须由匹配器提供，而参数"third argument"并非由参数匹配器提供，因此的缘故会抛出异常*//*
    }

    @Test
    public void test1() {
        LinkedList mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        // 下面的两个验证函数效果一样,因为verify默认验证的就是times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        // 验证具体的执行次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        // 使用never()进行验证,never相当于times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        // 使用atLeast()/atMost()
        // 至少1次
        verify(mockedList, atLeastOnce()).add("three times");
        // 最少
        verify(mockedList, atLeast(0)).add("five times");
        // 最多五次
        verify(mockedList, atMost(5)).add("three times");
    }


    @Test
    public void test2() {
        // A. Single mock whose methods must be invoked in a particular order
        // A. 验证mock一个对象的函数执行顺序
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //create an inOrder verifier for a single mock
        // 为该mock对象创建一个inOrder对象
        InOrder inOrder = inOrder(singleMock);

        //following will make sure that add is first called with "was added first, then with "was added second"
        // 确保add函数首先执行的是add("was added first"),然后才是add("was added second")
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        // B .验证多个mock对象的函数执行顺序
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        // 为这两个Mock对象创建inOrder对象
        inOrder = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        // 验证它们的执行顺序
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");

        // Oh, and A + B can be mixed together at will
    }

    @Test
    public void test3() {
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);
        //using mocks - only mockOne is interacted
        // 使用Mock对象
        mockOne.add("one");
        mockThree.add("one");

        //ordinary verification
        // 普通验证
        verify(mockOne).add("one");

        //verify that method was never called on a mock
        // 验证某个交互是否从未被执行
        verify(mockOne, never()).add("two");

        //verify that other mocks were not interacted
        // 验证mock对象没有交互过
        verifyZeroInteractions(mockTwo, mockThree);

    }

    @Test
    public void test4() {
        List mockedList = mock(List.class);
        //using mocks
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");

        //following verification will fail
        // 下面的验证将会失败 滥用，推荐使用never()
        verify(mockedList,never());
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void test5() {
        User mock = mock(User.class);
        when(mock.someMethod("some arg"))
                .thenThrow(new RuntimeException())
                .thenReturn("foo");

        try{
            //First call: throws runtime exception:
            // 第一次调用 : 抛出运行时异常
            mock.someMethod("some arg");
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
        }

        //Second call: prints "foo"
        // 第二次调用 : 输出"foo"
        System.out.println(mock.someMethod("some arg"));

        //Any consecutive call: prints "foo" as well (last stubbing wins).
        // 后续调用 : 也是输出"foo"
        System.out.println(mock.someMethod("some arg"));


        // 第一次调用时返回"one",第二次返回"two",第三次返回"three"
        when(mock.someMethod("some arg"))
                .thenReturn("one", "two", "three");

        System.out.println(mock.someMethod("some arg"));
        System.out.println(mock.someMethod("some arg"));
        System.out.println(mock.someMethod("some arg"));

    }


    @Test
    public void test6() {
        User mock = mock(User.class);
        when(mock.someMethod(anyString())).thenAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                System.out.println(args);
                Object mock = invocation.getMock();
                return "called with arguments: " + Arrays.toString(args);
            }
        });

        //Following prints "called with arguments: foo"
        // 输出 : "called with arguments: foo"
        System.out.println(mock.someMethod("foo"));
    }


    @Test
    public void test7() {
        List list = new LinkedList();
        List spy = spy(list);

        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        // 不可能 : 因为当调用spy.get(0)时会调用真实对象的get(0)函数,此时会发生IndexOutOfBoundsException异常，因为真实List对象是空的
        try{
            when(spy.get(0)).thenReturn("foo");
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
        }

        //You have to use doReturn() for stubbing
        // 你需要使用doReturn()来打桩
        doReturn("foo").when(spy).get(0);
        System.out.println(spy.get(0));
    }

    @Test
    public void test8() {
        List list = new LinkedList();
        List spy = spy(list);

        //optionally, you can stub out some methods:
        // 你可以为某些函数打桩
        when(spy.size()).thenReturn(100);

        //using the spy calls *real* methods
        // 通过spy对象调用真实对象的函数
        spy.add("one");
        spy.add("two");

        //prints "one" - the first element of a list
        // 输出第一个元素
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        // 因为size()函数被打桩了,因此这里返回的是100
        System.out.println(spy.size());

        //optionally, you can verify
        // 交互验证
        verify(spy).add("one");
        verify(spy).add("two");
    }

    @Test
    public void test9() {
        Foo mock = mock(Foo.class, Mockito.RETURNS_SMART_NULLS);
        Foo mockTwo = mock(Foo.class, new YourOwnAnswer());
    }

    @Test
    public void test10() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(10);
        mock.add(1);

        verify(mock).add(1);


        reset(mock);
        //at this point the mock forgot any interactions & stubbin
        doReturn("1").when(mock.get(0));
        System.out.println(mock.get(0));
    }

    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = spy(list);

        // 对 spy.size() 进行定制.
        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        // 因为我们没有对 get(0), get(1) 方法进行定制,
        // 因此这些调用其实是调用的真实对象的方法.
        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");
        Assert.assertEquals(spy.size(), 100);
    }

    @Data
    public class User {
        public String someMethod(String name){
            return null;
        }

        public String someMethod(){
            return null;
        }
    }

    @Test
    public void testCaptureArgument() {
        List<String> list = Arrays.asList("1", "2");
        List mockedList = mock(List.class);
        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        mockedList.addAll(list);
        verify(mockedList).addAll(argument.capture());

        Assert.assertEquals(2, argument.getValue().size());
        Assert.assertEquals(list, argument.getValue());
    }

    @Test
    public void test12() {
        List serializableMock = mock(List.class, withSettings().serializable());
        System.out.println(serializableMock);
    }

    @Test
    public void test13() {
        User mock = mock(User.class);
        try{
            // will print a custom message on verification failure
            verify(mock, description("This will print on failure")).someMethod();
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
        }

        // will work with any verification mode
        verify(mock, times(2).description("someMethod should be called twice")).someMethod();
    }

    @Test
    public void test14() {
        User mock = mock(User.class);
        //passes when someMethod() is called within given time span
        verify(mock, timeout(100)).someMethod();
        //above is an alias to:
        verify(mock, timeout(100).times(1)).someMethod();

        //passes when someMethod() is called *exactly* 2 times within given time span
        verify(mock, timeout(100).times(2)).someMethod();

        //passes when someMethod() is called *at least* 2 times within given time span
        verify(mock, timeout(100).atLeast(2)).someMethod();

        //verifies someMethod() within given time span using given verification mode
        //useful only if you have your own custom verification modes.
        //verify(mock, new Timeout(100, yourOwnVerificationMode)).someMethod();
    }

    @Test
    public void test16() {
        User mock = mock(User.class);
        InOrder inOrder = inOrder(mock);
        mock.someMethod("some arg");
        mock.someMethod("some arg");

        inOrder.verify( mock, calls( 2 )).someMethod( "some arg" );
    }

    @Test
    public  void test17() {
        User mock = mock(User.class);
        doReturn("yes").when(mock).someMethod(anyString());
        System.out.println(mock.someMethod("some arg"));
        System.out.println(mock.someMethod("some arg111"));
    }*/

    @Test
    public void test19() {
        Foo mock = PowerMockito.mock(Foo.class);
        try {
            PowerMockito.doNothing().when(mock, "say", ArgumentMatchers.anyString());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
}
