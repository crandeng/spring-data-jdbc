/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.relational.core.sql;

import org.springframework.util.Assert;

/**
 * Interface for implementations that wish to be visited by a {@link Visitor}.
 *
 * @author Mark Paluch
 * @see Visitor
 */
public interface Visitable {

	/**
	 * Accept a {@link Visitor} visiting this {@link Segment} and its nested {@link Segment}s if applicable.
	 *
	 * @param visitor the visitor to notify, must not be {@literal null}.
	 */
	default void visit(Visitor visitor) {

		Assert.notNull(visitor, "Visitor must not be null!");

		visitor.enter(this);
		visitor.leave(this);
	}
}