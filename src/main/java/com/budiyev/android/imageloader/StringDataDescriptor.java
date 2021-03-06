/*
 * MIT License
 *
 * Copyright (c) 2017 Yuriy Budiyev [yuriy.budiyev@yandex.ru]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.budiyev.android.imageloader;

import android.support.annotation.NonNull;

final class StringDataDescriptor<T> implements DataDescriptor<T> {
    private final T mData;
    private final String mKey;

    public StringDataDescriptor(@NonNull T data) {
        mData = data;
        mKey = DataUtils.generateSHA256(data.toString());
    }

    @NonNull
    @Override
    public T getData() {
        return mData;
    }

    @NonNull
    @Override
    public String getKey() {
        return mKey;
    }

    @Override
    public int hashCode() {
        return mKey.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof StringDataDescriptor &&
                mKey.equals(((StringDataDescriptor) obj).mKey);
    }

    @NonNull
    @Override
    public String toString() {
        return "DataDescriptor [key: " + mKey + ", data: " + mData + "]";
    }
}
