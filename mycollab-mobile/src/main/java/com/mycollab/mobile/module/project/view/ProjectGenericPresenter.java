/**
 * Copyright © MyCollab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycollab.mobile.module.project.view;

import com.mycollab.vaadin.EventBusFactory;
import com.mycollab.mobile.module.project.event.ProjectEvent;
import com.mycollab.mobile.mvp.AbstractPresenter;
import com.mycollab.mobile.shell.event.ShellEvent;
import com.mycollab.vaadin.mvp.PageView;

/**
 * @author MyCollab Ltd
 * @since 5.2.9
 */
public abstract class ProjectGenericPresenter<V extends PageView> extends AbstractPresenter<V> {
    public ProjectGenericPresenter(Class<V> view) {
        super(view);
    }

    @Override
    protected void onErrorStopChain(Throwable throwable) {
        super.onErrorStopChain(throwable);
        if (this instanceof ProjectViewPresenter) {
            EventBusFactory.getInstance().post(new ShellEvent.GotoProjectModule(this, new String[]{"dashboard"}));
        } else {
            EventBusFactory.getInstance().post(new ProjectEvent.GotoDashboard(this, null));
        }
    }
}
