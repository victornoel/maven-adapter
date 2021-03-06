/*
 * MIT License
 *
 * Copyright (c) 2020 Artipie
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
package com.artipie.maven.file;

import com.artipie.asto.Key;
import com.artipie.asto.Storage;
import java.nio.ByteBuffer;
import org.cactoos.Text;
import org.reactivestreams.Publisher;

/**
 * Maven file abstraction.
 *
 * Represents a file into a maven repository.
 *
 * @since 0.2
 * @todo #58:30min Implement file storage using artipie/asto Storage.
 *  Finish File.Asto implementation and then remove the disabled
 *  annotation from the tests in AstoFileTest.
 */
public interface File {

    /**
     * File contents.
     *
     * @return File contents.
     */
    Publisher<ByteBuffer> content();

    /**
     * File name.
     *
     * @return File name.
     */
    Text name();

    /**
     * File implemented in Asto storage.
     *
     * @since 0.2
     */
    class Asto implements File {

        /**
         * Asto key for File.
         */
        private final Key key;

        /**
         * Asto storage.
         */
        private final Storage storage;

        /**
         * Constructor.
         *
         * @param key Asto key.
         * @param storage Asto storage.
         */
        Asto(final Key key, final Storage storage) {
            this.key = key;
            this.storage = storage;
        }

        @Override
        public Publisher<ByteBuffer> content() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Text name() {
            throw new UnsupportedOperationException();
        }
    }
}
