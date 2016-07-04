package com.denis.shuvalov.other.functor;

import com.denis.shuvalov.other.functor.example.MyFunction;

/**
 * An extra F type parameter was required to make Identity compile.
 * What you saw in the preceding example was the simplest functor
 * just holding a value. All you can do with that value is transforming
 * it inside map method, but there is no way to extract it. This is
 * considered beyond the scope of a pure functor. The only way to interact
 * with functor is by applying sequences of type-safe transformations
 */
public interface Functor<T, F extends Functor<?, ?>> {

    <R> F map(MyFunction<T, R> function);
}

class Identity<T> implements Functor<T, Identity<?>> {
    private final T value;

    Identity(T value) {
        this.value = value;
    }

    @Override
    public <R> Identity<R> map(MyFunction<T, R> function) {
        final R result = function.apply(value);
        return new Identity<>(result);
    }
}

class Sample {
    public static void main(String[] args) {
        Identity<String> idString = new Identity<>("abc");
        Identity<Integer> idInt = idString.map(String::length);

        Customer customer = new Customer();
        Identity<byte[]> idBytes = new Identity<>(customer)
                .map(Customer::getAddress)
                .map(Address::getStreet)
                .map(s -> s.substring(0, 3))
                .map(String::toLowerCase)
                .map(String::getBytes);

        //Same as
        byte[] bytes = customer
                .getAddress()
                .getStreet()
                .substring(0, 3)
                .toLowerCase()
                .getBytes();
    }
}

class Customer {
    Address address;

    Address getAddress() {
        return address;
    }
}

class Address {
    String street;

    String getStreet() {
        return street;
    }
}