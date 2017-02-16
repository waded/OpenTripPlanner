/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.routing.edgetype.temporary;

import org.onebusaway.gtfs.model.Stop;
import org.opentripplanner.routing.edgetype.PatternHop;
import org.opentripplanner.routing.edgetype.TemporaryEdge;
import org.opentripplanner.routing.vertextype.PatternStopVertex;


public class TemporaryPatternHop extends PatternHop implements TemporaryEdge {

    // How much shorter is the hop geometry for the flag stop relative to the original length?
    // We use this to calculate arrivals at flag stops.
    public double distanceRatio;

    public TemporaryPatternHop(PatternStopVertex from, PatternStopVertex to, Stop begin, Stop end, int stopIndex, Double distanceRatio) {
        super(from, to, begin, end, stopIndex);
        this.distanceRatio = distanceRatio;
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }

    @Override
    public void dispose() {
        fromv.removeOutgoing(this);
        tov.removeIncoming(this);
    }
}
